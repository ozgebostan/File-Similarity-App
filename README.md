# 🔍 File Similarity Analyzer

A Java desktop application designed to calculate text similarity between two files using advanced design patterns and concurrent processing. 

---

## 🏗️ Architectural Overview
* **Strategy Design Pattern:** Used to decouple the similarity calculation logic. This allows for easy switching between different algorithms like **Jaccard Similarity**, **Cosine Similarity** without changing the core manager.
* **Multi-threading:** Leverages `Runnable` and `Thread` classes to read multiple files concurrently, optimizing performance for large data sets.
* **Component-Based UI:** Modular Swing components for better maintainability.

---

## 🚀 Technical Features

* **Jaccard Similarity Index:** Calculates similarity based on set theory.
* **Asynchronous File Processing:** Uses `FileReaderThread` to parse files into frequency maps without blocking the main logic.
* **Intelligent Analysis:** Categorizes results into "Same File", "Possible Plagiarism", or "Low Similarity" with formatted percentage outputs.
* **Regex Tokenization:** Processes text by normalizing case and splitting strings into clean tokens.

---

## 🛠️ Tech Stack

* **Language:** Java (JDK 17+)
* **Framework:** Java Swing (GUI)
* **Design Patterns:** Strategy Pattern, Composite-style Architecture.
* **Concurrency:** Java Threads for thread-safe-like map updates.

---

## 📊 Logic & Math
The core logic uses the **Jaccard Index**:
$$J(A, B) = \frac{|A \cap B|}{|A \cup B|}$$
Where $A$ and $B$ are sets of unique words from each file.

---

## 🔮 Future Enhancements (Roadmap)

* **Interactive File Selection:** Replacing manual path entry with `JFileChooser` for a more user-friendly experience.
* **Export Feature:** Ability to save analysis reports as `.pdf` or `.txt`.

---

## ⚙️ How to Run
1.  **Compile:** Open the project in IntelliJ IDEA or any Java IDE.
2.  **Execute:** Run the `FileSimilarityApp.java` to start the GUI.
3.  **Analyze:** Enter full file paths and click **"Calculate"**.

---

## 👨‍💻 Author
**Özge Bostan** - Software Engineering Student at Izmir University of Economics.
* [LinkedIn](https://www.linkedin.com/in/ozge-bostan)
