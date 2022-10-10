# School Manager:

## Folder Structure

### Helpers:
Enum Variables needed as: 
- **Education Level**
  - **ELEMENTARY_SCHOOL_SUBJECT**
    - mathematics, science, language, arts, music, reading
  - **MIDDLE_SCHOOL_SUBJECT**
    - mathematics, literature, science, religion, foreign_language
  - **HIGH_SCHOOL_SUBJECT**
    - mathematics, science, geometry, algebra, biology, physics, chemestry, history, art, music, physical education
- **Grades**
  - A, B, C, D, E, F

### Models
School
Student
Subject
Teacher

### Repositories
Student Repository - Student Data
Teacher Repository - Teacher Data
### Services
Access Validator
Read Data
Write Data
### Resources


List of Students and Teachers, each one has a unique code

Students have this information:
|  Field | Description |
|---|---|
| Name | Name of Student|
| Age | Age of Student|
| Education Level | Types of levels in American Schools |
| Subjects | List of Subjects with Grades for students and no grades for Teachers|