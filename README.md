# Hashira-ProblemStatement
# Polynomial From JSON  

This project reads polynomial data from a JSON file and processes it using the **org.json** library.  

---

## 📂 Project Structure  
POLYNOMIALPROJECT/
│
├── lib/
│ └── json-20240303.jar # External JSON library
│
├── PolynomialFromJSON.java # Main Java source file
├── testcase.json # Input JSON file
└── README.md # Project documentation

---

## ⚙️ Requirements  

- Java JDK 8 or later  
- `json-20240303.jar` (already included in the `lib` folder)  

---

## ▶️ How to Compile  

### On **Windows (PowerShell/CMD)**  
```bash
javac -cp ".;lib/json-20240303.jar" PolynomialFromJSON.java
🚀 How to Run
On Windows
java -cp ".;lib/json-20240303.jar" PolynomialFromJSON
📝 Example Input (testcase.json)
{
  "polynomial": "3x^2 + 2x + 1"
}
📌 Notes

Keep testcase.json in the same folder as your .java file (or adjust the path in code).

Do not upload .class files or .vscode settings to GitHub. Only .java, .json, .jar, and README.md.
