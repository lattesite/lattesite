---
name: java
description: Write Java code following this repository's conventions
---

Write Java code for this repository following these conventions:

## Style: POJO

- No frameworks, no dependency injection, no Lombok, no code-generation annotations
- No `@Inject`, `@Autowired`, `@Component`, `@Data`, or similar
- Only standard JDK annotations: `@Override`, `@FunctionalInterface`, `@Deprecated`, `@SuppressWarnings`
- Dependencies are passed explicitly via constructor parameters

## Style: Explicit

- Always use `this.field` when referencing instance fields
- Declare all instance fields at the top of the class with explicit access modifiers
- Use `private final` for fields that are set in the constructor and never reassigned
- No `var` — always write the explicit type
- Constructor delegation uses `this(...)` for overloads rather than duplicating logic
- Validation in setters throws `Exception` with a descriptive message (not silent no-ops or unchecked exceptions)
- Use `LinkedHashMap` / `LinkedHashSet` when insertion order matters

## Style: JDK 17

- Use `List.of(...)`, `Map.of(...)`, `Set.of(...)` for immutable collections
- Use text blocks (`"""..."""`) for multi-line strings (e.g. XML, HTML, JSON templates)
- Use switch expressions (`switch (...) { case X -> ... }`) instead of switch statements where a value is returned
- Use `instanceof` pattern matching (`if (x instanceof Foo f)`) instead of explicit casts
- Records are acceptable for simple, immutable data carriers with no behaviour
- Sealed interfaces are acceptable when a fixed set of subtypes must be enforced

## Class structure (in order)

1. Static constants
2. Instance fields
3. Constructors (narrowest overload delegates to broadest via `this(...)`)
4. Public methods
5. Private methods
6. Inner classes / interfaces

## Javadoc

- Add a single-line class-level Javadoc only when the class name alone is not self-explanatory
- Add `@param` and `@return` on public methods when the meaning is not obvious from the signature
- No multi-paragraph docstrings; one short sentence is enough
