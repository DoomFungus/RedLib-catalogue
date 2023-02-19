# Book Search DSL

## General

To give more flexibility in searching books, a simple JSON-based DSL was created. It provides client application a way to construct their own queries, using comparison operators as well as logical operators.

### 1 Accessing search endpoint
Search can be accessed via POST <search host>/search/book

### 2 Structure of the request

The JSON request is a tree structure,  with nodes having following fields:
- operation: a string with node type
- children: collection of children nodes. Present at non-terminal nodes
- field: string with queried field name. Present at terminal nodes
- value: collection of strings to be used for comparison with a field value. Present at terminal nodes

### 3 Operation types

The field 'operation' can take following values:
- EQUALS. Equality operator. Terminal operator. Use only for single-value fields
- CONTAINS. Checks if all given values are present. Terminal operator. Use only for multiple-value fields
- AND. Non-terminal operator
- OR. Non-terminal operator
- NOR. Non-terminal operator

### 4 Queriable fields

The field 'field' can take following values:

- BOOK_NAME. Book name. Single field
- AUTHOR_NAME. Author names. Multiple field
- TAG. Tags. Multiple field
- BOOK_SUMMARY. Book summary. Single field

### 5 Example

An example of JSON request can be found [here](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/dsl_example.json)
