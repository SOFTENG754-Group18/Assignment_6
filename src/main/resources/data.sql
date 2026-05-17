INSERT INTO lesson (id, title) VALUES (1, 'Java Basics');
INSERT INTO lesson (id, title) VALUES (2, 'Object-Oriented Programming');
INSERT INTO lesson (id, title) VALUES (3, 'Data Structures');

INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (1, 1, 'Which keyword declares a constant in Java?', 'final', 'const', 'static', 'constant', 0);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (2, 1, 'Which primitive type stores a single character?', 'String', 'char', 'int', 'boolean', 1);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (3, 1, 'What is the default value of an int instance field?', 'null', '0', '1', '-1', 1);

INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (4, 2, 'What does encapsulation primarily provide?', 'Faster execution', 'Data hiding', 'Multiple inheritance', 'Static typing', 1);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (5, 2, 'Which keyword is used for class inheritance in Java?', 'implements', 'inherits', 'extends', 'super', 2);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (6, 2, 'What is an object?', 'A class blueprint', 'An instance of a class', 'A method signature', 'A package', 1);

INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (7, 3, 'Which data structure follows FIFO ordering?', 'Stack', 'Queue', 'Tree', 'Graph', 1);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (8, 3, 'What is the time complexity of accessing an array element by index?', 'O(n)', 'O(log n)', 'O(1)', 'O(n^2)', 2);
INSERT INTO question (id, lesson_id, text, option1, option2, option3, option4, correct_index)
VALUES (9, 3, 'Which data structure follows LIFO ordering?', 'Queue', 'Stack', 'Linked list', 'Hash map', 1);
