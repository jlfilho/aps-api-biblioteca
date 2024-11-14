-- Inserindo categorias
INSERT INTO categoria (codigo, nome) VALUES (1, 'Ficção Científica');
INSERT INTO categoria (codigo, nome) VALUES (2, 'Fantasia');
INSERT INTO categoria (codigo, nome) VALUES (3, 'Romance');
INSERT INTO categoria (codigo, nome) VALUES (4, 'História');
INSERT INTO categoria (codigo, nome) VALUES (5, 'Biografia');

-- Inserindo autores
INSERT INTO autor (codigo, nome, nacionalidade) VALUES (1, 'Isaac Asimov', 'Russo-Americano');
INSERT INTO autor (codigo, nome, nacionalidade) VALUES (2, 'J.R.R. Tolkien', 'Britânico');
INSERT INTO autor (codigo, nome, nacionalidade) VALUES (3, 'Jane Austen', 'Britânica');
INSERT INTO autor (codigo, nome, nacionalidade) VALUES (4, 'Yuval Noah Harari', 'Israelense');
INSERT INTO autor (codigo, nome, nacionalidade) VALUES (5, 'Walter Isaacson', 'Americano');

-- Inserindo livros
INSERT INTO livro (codigo, titulo, ano_publicacao, isbn, categoria_id) VALUES (1, 'Fundação', 1951, '9788535902778', 1);
INSERT INTO livro (codigo, titulo, ano_publicacao, isbn, categoria_id) VALUES (2, 'O Senhor dos Anéis', 1954, '9780544003415', 2);
INSERT INTO livro (codigo, titulo, ano_publicacao, isbn, categoria_id) VALUES (3, 'Orgulho e Preconceito', 1813, '9780141439518', 3);
INSERT INTO livro (codigo, titulo, ano_publicacao, isbn, categoria_id) VALUES (4, 'Sapiens: Uma Breve História da Humanidade', 2011, '9780062316097', 4);
INSERT INTO livro (codigo, titulo, ano_publicacao, isbn, categoria_id) VALUES (5, 'Steve Jobs', 2011, '9781451648546', 5);

-- Inserindo associações entre livros e autores (livro_autor)
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 1); -- Fundação, Isaac Asimov
INSERT INTO livro_autor (livro_id, autor_id) VALUES (2, 2); -- O Senhor dos Anéis, J.R.R. Tolkien
INSERT INTO livro_autor (livro_id, autor_id) VALUES (3, 3); -- Orgulho e Preconceito, Jane Austen
INSERT INTO livro_autor (livro_id, autor_id) VALUES (4, 4); -- Sapiens, Yuval Noah Harari
INSERT INTO livro_autor (livro_id, autor_id) VALUES (5, 5); -- Steve Jobs, Walter Isaacson
