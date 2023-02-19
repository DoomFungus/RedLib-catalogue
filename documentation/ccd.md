# Clean Code Developement 

## General code
1. Code should be split into objects, objects should encompass all logic regarding the part of the domain. No more, no less
2. Code should be organized into functions that do 1 thing. Side effects should be minimized and documented.
3. Function should be easy to read and understand
4. Use self-descriptive variable and parameter names
5. Don't leave commented-out code
6. Use descriptive exceptions
7. Use comments if they are required for comprehension
8. Reuse and recycle

## Tests
1. Prefer unit test over integration test and integration test over manual test
2. Unit tests should check only 1 condition, it should be reflected in test name (Not necessarily 1 assert, but 1 logical condition)
3. Don't leave disabled test without responsibility to fix it. Add responsible person and a blocking condition
4. Unit tests should have a following name pattern: should_\<TestedCondition\>\_When\_\<TestPrecondition\>

## Code style
1. We have a SonarQube. Check it frequently and fix the code smells
