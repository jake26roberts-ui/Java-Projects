# Task Manager CLI — Requirements

Purpose
- Build a small CLI-style task manager to practice and demonstrate Java fundamentals: OOP, collections, file I/O, serialization, and unit testing.

Learning goals
- Keep domain model and business logic separate from any UI/CLI glue.
- Implement persistence (JSON).
- Write unit tests for core behavior (JUnit 5).
- Practice clean code, small focused commits, and documenting design decisions.

Minimum (MVP) Requirements — must be implemented
1. Domain:
   - Task entity with: id (unique), title (required), description (optional), dueDate (optional), status (TODO / DONE).
2. Core operations (TaskManager / service class):
   - addTask(title, description?, dueDate?)
   - listTasks() -> returns id, title, status, due date
   - completeTask(id) -> mark DONE
   - reopenTask(id) -> mark TODO
   - removeTask(id)
3. Persistence:
   - Save tasks to disk in JSON format (file located in a `data/` folder, default name `data/tasks.json`).
   - Load tasks on app initialization; create an empty file or data structure if missing.
   - Persistence layer (adapter) must be separable and testable independently of the CLI.
4. CLI interface (implementation detail only):
   - Provide a simple command-surface (commands: add, list, complete, reopen, remove, help).
   - Validate inputs and return or surface helpful error messages; core logic must not depend on input parsing.
   - Design so the CLI is a thin layer that delegates to TaskManager.
5. Tests:
   - Unit tests for TaskManager covering main flows and edge cases (invalid id, empty title, persistence adapter behavior).
   - Integration-style tests for persistence adapter that use a temporary file or test-specific data path.
6. Project artifacts:
   - Include a build descriptor file (pom.xml or build.gradle) so the project structure is explicit.
   - README that states the project purpose, learning goals, and how the code is organized (no run instructions required).
   - NOTES.md / design.md containing key design decisions and lessons learned.

Non-functional requirements
- Target Java 17+ (or current LTS) for language features and APIs.
- Use JUnit 5 for tests.
- Use a JSON library (Jackson or Gson) for serialization.
- Prefer immutability where appropriate (use final fields), avoid public mutable fields.
- Keep classes and methods small and single-responsibility.
- Use interfaces to allow swapping/mocking persistence or other components in tests.
- Make commits small and focused with descriptive messages.

Acceptance criteria (how to know it's done)
- The TaskManager implementation supports add/list/complete/reopen/remove and exposes a persistence adapter that saves and loads tasks in JSON.
- The persistence adapter creates/initializes the data file or returns an empty dataset when none exists.
- Unit tests for core logic and persistence adapter exist and pass in your local environment.
- README documents project purpose, learning goals, and code layout.
- NOTES.md/design.md includes at least one recorded design decision and one lesson learned.

Optional (stretch) features — pick any if you want extra practice
- Tagging and filtering (by tag, due date, or status).
- Import/export CSV adapter in addition to JSON.
- Undo support for the last operation (in-memory command pattern).
- Use a small CLI parsing library (e.g., picocli) for nicer CLI structure (implementation-only; no run docs required).
- Add basic benchmarks for algorithmic parts using JMH (if you implement custom data structures).

Notes
- Keep the core logic independent of how you run or package the project; this makes it easier to place code into different sections of a repository without changing behavior.
- Record tradeoffs and any deviations from these requirements in NOTES.md.
