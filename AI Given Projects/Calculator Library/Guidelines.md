# Simple Calculator Library — Requirements

Purpose
- Build a small library that parses and evaluates arithmetic expressions to practice Java fundamentals: parsing, expression evaluation, OOP, testing, error handling, and clean API design.

Learning goals
- Separate parsing, AST (abstract syntax tree) construction, and evaluation logic.
- Handle operator precedence and parentheses correctly.
- Design a clean, testable public API usable from other code or tests.
- Practice defensive programming and descriptive error reporting for malformed input.

Minimum (MVP) Requirements — must be implemented
1. Public API:
   - Calculator.evaluate(String expression) : Number (or BigDecimal) — accepts an expression string and returns the numeric result.
   - Calculator.parse(String expression) : ExpressionNode — optional helper to expose parsing output for tests.
   - Clear exception type(s) for parse/eval errors (e.g., CalculatorParseException, CalculatorEvalException).

2. Language supported (minimum):
   - Binary operators: +, -, *, /
   - Correct operator precedence (* and / before + and -)
   - Parentheses: ( and ) to override precedence
   - Unary minus for negative numbers (e.g., "-5" and "2 * -3")
   - Numeric literals: integers and decimals (e.g., 2, 3.14)

3. Structure:
   - Parser: converts input string into an AST (ExpressionNode classes).
   - Evaluator: walks the AST and computes the result.
   - Keep parser and evaluator decoupled so each can be unit-tested separately.
   - Provide small, focused classes (e.g., Tokenizer/Lexer, Parser, AST nodes, Evaluator, Calculator facade).

4. Error handling:
   - Detect and throw meaningful exceptions for syntax errors (unmatched parentheses, invalid tokens), divide-by-zero, and other evaluation errors.
   - Exceptions should include location/context where possible (e.g., token index or snippet).

5. Tests:
   - Unit tests for parser, AST, and evaluator covering:
     - Simple expressions: "1+2", "4*5"
     - Precedence: "1+2*3" => 7
     - Parentheses: "(1+2)*3" => 9
     - Unary minus: "-3+5" => 2 and "2 * -3" => -6
     - Decimals: "3.5*2" => 7.0
     - Error cases: "1++2", "(", "2/0"
   - Aim for clear, behavior-focused tests (edge cases and common misuse).

6. Project artifacts:
   - Include a build descriptor file (pom.xml or build.gradle) to make the module explicit.
   - README that states project purpose, learning goals, and code layout (no run instructions required).
   - NOTES.md or design.md with parser approach and lessons learned.

Non-functional requirements
- Target Java 17+ (or current LTS).
- Use JUnit 5 for tests.
- Use BigDecimal for numeric calculations if you want precise decimal behavior; otherwise document the chosen numeric type and its tradeoffs.
- Use interfaces where it aids swapping implementations (e.g., EvaluatorStrategy).
- Keep classes and methods small with single responsibility.
- Favor immutability in AST nodes where practical (use final fields).
- Make commits small and focused with descriptive messages.

Acceptance criteria (how to know it's done)
- Calculator.evaluate returns correct results for arithmetic expressions that exercise precedence, parentheses, unary minus, and decimals.
- Parser and evaluator each have unit tests that pass.
- Parse/eval errors produce descriptive exceptions and are covered by tests.
- README documents the library purpose, public API, and file layout.
- NOTES.md/design.md records the parsing strategy chosen (recursive descent, shunting-yard, etc.) and at least one lesson learned.

Optional (stretch) features — pick any for extra practice
- Support exponentiation operator ^ with correct precedence and associativity.
- Add variables and an evaluate(String expression, Map<String, Number> variables) API.
- Implement functions (sin, cos, max) and function calls (e.g., max(1,2)).
- Provide a tokenizer that preserves token positions for richer error messages.
- Benchmark parser/evaluator performance for long expressions.
- Implement both a recursive-descent parser and a shunting-yard implementation and compare correctness/complexity.

Notes
- Choose and document one parsing approach (e.g., recursive descent or shunting-yard) in NOTES.md.
- If you use BigDecimal, decide and document the scale/rounding strategy for division.
- Keep the core library independent of any CLI or UI so it can be dropped into different sections of the repository easily.
