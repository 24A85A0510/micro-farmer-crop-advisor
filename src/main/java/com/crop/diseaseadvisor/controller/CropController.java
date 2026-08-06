package com.crop.diseaseadvisor.controller;

import com.crop.diseaseadvisor.model.DiagnosisResult;
import com.crop.diseaseadvisor.service.InferenceService;
import com.crop.diseaseadvisor.service.RemedyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Controller
public class CropController {

    private final InferenceService inferenceService;
    private final RemedyService remedyService;

    public CropController(InferenceService inferenceService, RemedyService remedyService) {
        this.inferenceService = inferenceService;
        this.remedyService = remedyService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/diagnose")
    public String handleGetDiagnose() {
        return "redirect:/";
    }

    @PostMapping("/diagnose")
    public String diagnose(@RequestParam("image") MultipartFile file, Model model) {
        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "Please select a valid leaf image file before submitting.");
            return "index";
        }

        try {
            DiagnosisResult result = inferenceService.predict(file);
            String organicRemedy = remedyService.getRemedy(result.diseaseName());

            String base64Image = Base64.getEncoder().encodeToString(file.getBytes());

            model.addAttribute("disease", result.diseaseName().replace("___", " - "));
            model.addAttribute("confidence", String.format("%.1f", result.confidence()));
            model.addAttribute("remedy", organicRemedy);
            model.addAttribute("imageData", base64Image);
            model.addAttribute("success", true);

        } catch (Exception e) {
            model.addAttribute("error", "Error processing image: " + e.getMessage());
        }

        return "index";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(Model model) {
        model.addAttribute("error", "File is too large! Please upload a leaf image smaller than 10 MB.");
        return "index";
    }
}