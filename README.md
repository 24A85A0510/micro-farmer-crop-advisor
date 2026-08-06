# Micro-Farmer Crop Disease Advisor 🌿

An end-to-end, production-ready computer vision web application designed to help farmers instantly detect crop diseases from leaf images and receive organic treatment remedies.

Built with **Java 21**, **Spring Boot 4.1.0**, and **ONNX Runtime**, containerized with **Docker**.

---

## 🚀 Key Features

- **In-Memory Machine Learning Inference**: Uses Microsoft's ONNX Runtime JNI bindings to run a pre-trained **MobileNetV2** model across 38 PlantVillage disease classes locally without external API dependencies.
- **Confidence Scoring**: Computes Softmax probability distributions to display classification confidence percentages.
- **Responsive UI**: Built with Spring Boot Thymeleaf and Bootstrap, featuring instant image previewing and disease remedies.
- **Containerized Deployment**: Multi-stage Docker build utilizing Ubuntu-based JRE (`eclipse-temurin:21-jre`) to support native dynamic linking for `libonnxruntime.so` (`glibc`).

---

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 4.1.0 (Web, Thymeleaf)
- **Machine Learning**: ONNX Runtime Java (`com.microsoft.onnxruntime`), MobileNetV2
- **Frontend**: HTML5, Thymeleaf, Bootstrap 5
- **Containerization**: Docker (Multi-stage build, Maven 3.9.6, Eclipse Temurin JRE 21)

---

## 🏗️ Architecture Flow

1. **User Request**: User uploads a leaf photo via the web interface (`POST /diagnose`).
2. **Preprocessing**: Image is buffered, resized to $224 \times 224$ pixels, and converted into a $1 \times 3 \times 224 \times 224$ normalized float tensor.
3. **ONNX Inference**: Tensor is passed into `InferenceService`, where ONNX Runtime executes MobileNetV2 locally.
4. **Postprocessing**: Softmax function maps raw logits to a 38-class PlantVillage dataset, extracting top prediction label and confidence score.
5. **View Rendering**: Thymeleaf template displays the diagnosis, image preview, confidence percentage, and organic treatment plan.

---

## 🚦 Getting Started

### Prerequisites
- [Docker Desktop](https://www.docker.com/) installed and running.
- (Optional) Java 21 & Maven 3.9+ for local development.

### Running with Docker

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/your-username/micro-farmer-crop-advisor.git](https://github.com/your-username/micro-farmer-crop-advisor.git)
   cd micro-farmer-crop-advisor