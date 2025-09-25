# Campus Course & Records Manager (CCRM)

**Short description**  
A simple console-based Java app to manage students, courses, enrollments, grades, and basic file import/export. Menu-driven and built to demonstrate core Java features (OOP, enums, NIO.2, Streams, custom exceptions).

## Quick run (Eclipse)
1. Import project into Eclipse as a Java project (File → Import → Existing Projects or create new and copy `src/`).
2. Run the main class: `edu.ccrm.cli.MainApp`.

## Quick run (command line)
- Recommended: run in an IDE. If using command line, compile all `.java` files then run:
```bash
# from project root (adjust paths if needed)
javac -d out $(find src -name "*.java")
java -cp out edu.ccrm.cli.MainApp
