package com.crop.diseaseadvisor.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class RemedyService {

    private final Map<String, String> organicRemedies = new HashMap<>();

    public RemedyService() {
        // Blights & Leaf Spots
        organicRemedies.put("Tomato___Early_blight",
                "Spray homemade Neem Oil solution (5ml neem oil + 2ml liquid soap per liter of water) every 7 days. Prune lower infected foliage.");
        organicRemedies.put("Tomato___Late_blight",
                "Apply copper-based organic spray or wood ash on wet leaves to control moisture. Remove severely infected foliage immediately.");
        organicRemedies.put("Potato___Early_blight",
                "Spray copper hydroxide organic fungicide. Mulch soil surface to prevent soil-borne spore splashing.");
        organicRemedies.put("Potato___Late_blight",
                "Apply baking soda solution (1 tbsp baking soda + 1 tsp liquid soap per liter water) or copper spray weekly.");
        organicRemedies.put("Tomato___Bacterial_spot",
                "Spray copper-based organic bactericide combined with neem oil. Avoid overhead irrigation.");
        organicRemedies.put("Tomato___Septoria_leaf_spot",
                "Apply sulfur or copper dust. Destroy infected plant debris after harvest.");

        // Rusts & Mildews
        organicRemedies.put("Corn___Common_rust",
                "Apply a 1:9 milk-to-water ratio spray in direct sunlight or sulfur dust to stop fungal spore expansion.");
        organicRemedies.put("Cherry___Powdery_mildew",
                "Spray potassium bicarbonate solution (1 tbsp per liter water) or neem oil every 7-10 days.");
        organicRemedies.put("Squash___Powdery_mildew",
                "Spray diluted milk solution (40% milk, 60% water) under full sunlight to generate natural anti-fungal proteins.");

        // Scabs, Mites & Rot
        organicRemedies.put("Apple___Apple_scab",
                "Rake and destroy fallen leaves. Apply sulfur spray during green tip bud stage.");
        organicRemedies.put("Apple___Black_rot",
                "Prune dead or diseased branches back to healthy wood. Apply organic copper fungicide during spring.");
        organicRemedies.put("Tomato___Spider_mites Two-spotted_spider_mite",
                "Spray insecticidal soap or release predatory mites (Phytoseiulus persimilis). Ensure high humidity around foliage.");

        // Healthy Leaf Conditions
        organicRemedies.put("Tomato___healthy",
                "No disease detected! Maintain balanced compost application and proper drip irrigation.");
        organicRemedies.put("Potato___healthy",
                "Crop is healthy! Continue monitoring soil moisture and ensure proper earthing-up of tubers.");
        organicRemedies.put("Corn___healthy",
                "No disease detected! Keep fields weed-free and maintain healthy nitrogen levels.");
        organicRemedies.put("Apple___healthy",
                "Tree foliage is healthy! Continue regular pruning and orchard sanitation.");
        organicRemedies.put("Healthy",
                "No disease detected! Maintain proper soil drainage and regular weed control.");
    }

    public String getRemedy(String diseaseName) {
        return organicRemedies.getOrDefault(
                diseaseName,
                "Apply cold-pressed neem oil solution (5ml/L water) or bio-fungicide (Bacillus subtilis). Prune affected foliage and ensure adequate sunlight and air circulation."
        );
    }
}