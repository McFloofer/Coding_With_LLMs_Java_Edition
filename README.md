GenAI Java Code Compliance Benchmark

Created and Submitted by: 
Gestiada, Abbe Keith
Ilagan, Joshua
Mikunug, Abdul Aziz

Submitted to:
Far Eastern University - Institute of Technology
Mr. Alexander Hernandez

Disclaimer: This project is submitted in compliance with the academic requirements to mark the completion of the Course "CS0035 - Programming Languages" for the Computer Science program, specializing in Software 
Engineering, at Far Eastern University. It is strictly an educational and academic exercise. It is in no way, shape, or form intended to infringe upon any copyrighted material, proprietary software, or intellectual 
property. All referenced models, tools, and prior literature are the property of their respective copyright holders and are used here exclusively for non-commercial, academic research under fair use principles.

Overview
This repository contains the dataset and evaluation protocol for the GenAI Java Code Compliance Benchmark. The project investigates the effectiveness of Generative AI (LLMs) in acting as static code analysis tools 
and senior code reviewers.

This project builds upon prior empirical research evaluating LLMs on Python code violations by systematically migrating those violation taxonomies into their strict Java equivalents. The goal is to measure how well 
modern, free-tier, and open-weight models detect style, logic, security, and concurrency violations based on the Google Java Style Guide and enterprise best practices.

The "Trap" Dataset
Unlike standard code generation benchmarks (like HumanEval), this dataset is designed to test Code Evaluation.

The repository contains 75 curated Java snippets, known as "Traps". Each snippet compiles perfectly but contains intentionally injected violations ranging from trivial style issues to catastrophic runtime bugs.

The dataset is categorized into the following focus areas:

Style & Syntax: Naming conventions (PascalCase/camelCase), whitespace, and structural violations.

Maintainability: Resource leaks (unclosed streams), legacy class usage (Stack, Vector), and Magic Numbers.

Type Safety: Raw use of parameterized classes (List, Map, Set) and unsafe casting.

Security & Encapsulation: Public mutable arrays, exposed internal states, and hardcoded credentials.

Concurrency: Misunderstanding of the Java Memory Model (e.g., using volatile for non-atomic compound operations).

Control / False Positives: Perfectly compliant code to test if models hallucinate non-existent rules.

Evaluated Models
The current benchmark focuses on zero-cost and open-source models to ensure accessibility for student developers and academic researchers:

Claude 3.5 Sonnet (Anthropic - Free Tier)

GPT-4o mini (OpenAI)

DeepSeek-V3 (DeepSeek - Open Weight)

Gemini Flash (Google)

Qwen 2.5-Coder (Alibaba - Open Weight)

Kimi (Moonshot AI - Free Tier)

Methodology & Protocol
1. The Prompt
To ensure a standardized zero-shot evaluation, all models must be evaluated using the exact same prompt:

"Act as a Senior Java Developer conducting a strict code review based on Google Java Style and industry best practices. Review the following code. List every violation, bug, or code smell you find."

2. Evaluation Metrics
Outputs are manually graded against the definitive Answer Key provided in the /dataset directory. Models are evaluated on four mathematical criteria:

Precision: The model's reliability when it flags an issue (Penalizes hallucinated rules).

Recall: The model's ability to find all actual injected bugs (The "Catch Rate").

F1-Score: The harmonic mean of Precision and Recall.

False Discovery Rate (FDR): The proportion of False Positives among all predicted violations (The "Noise Level").

Repository Structure
How to Contribute
If you wish to test a new model (e.g., Llama 3, Mistral) against this benchmark:

Navigate to the /dataset folder and extract the "Clean Code" blocks.

Run the code blocks through your target model using the standardized prompt.

Grade the model's output strictly against the provided "Answer Key" for each snippet.

Calculate the True Positives (TP) and False Positives (FP).

Submit a Pull Request with your raw logs and calculated scores to be added to the Global Scorecard.

Acknowledgments
This dataset taxonomy was adapted and migrated to Java from the Python evaluation framework established in:
Salih, H. A. M., & Sarhan, Q. I. (2025). A Study of Large Language Models in Detecting Python Code Violations. ARO-The Scientific Journal of Koya University.
