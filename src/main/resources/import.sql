-- Inserindo categorias
INSERT INTO categoria (nome) VALUES ('Ficção Científica');
INSERT INTO categoria (nome) VALUES ('Fantasia');
INSERT INTO categoria (nome) VALUES ('Romance');
INSERT INTO categoria (nome) VALUES ('História');
INSERT INTO categoria (nome) VALUES ('Biografia');

-- Inserindo autores
INSERT INTO autor (nome, nacionalidade) VALUES ('Isaac Asimov', 'Russo-Americano');
INSERT INTO autor (nome, nacionalidade) VALUES ('J.R.R. Tolkien', 'Britânico');
INSERT INTO autor (nome, nacionalidade) VALUES ('Jane Austen', 'Britânica');
INSERT INTO autor (nome, nacionalidade) VALUES ('Yuval Noah Harari', 'Israelense');
INSERT INTO autor (nome, nacionalidade) VALUES ('Walter Isaacson', 'Americano');

-- Inserindo livros (usando IDs de categoria)
INSERT INTO livro (titulo, ano_publicacao, isbn, categoria_id) VALUES ('Fundação', 1951, '9788535902778', 1);
INSERT INTO livro (titulo, ano_publicacao, isbn, categoria_id) VALUES ('O Senhor dos Anéis', 1954, '9780544003415', 2);
INSERT INTO livro (titulo, ano_publicacao, isbn, categoria_id) VALUES ('Orgulho e Preconceito', 1813, '9780141439518', 3);
INSERT INTO livro (titulo, ano_publicacao, isbn, categoria_id) VALUES ('Sapiens: Uma Breve História da Humanidade', 2011, '9780062316097', 4);
INSERT INTO livro (titulo, ano_publicacao, isbn, categoria_id) VALUES ('Steve Jobs', 2011, '9781451648546', 5);

-- Inserindo associações entre livros e autores
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 1); -- Fundação, Isaac Asimov
INSERT INTO livro_autor (livro_id, autor_id) VALUES (2, 2); -- O Senhor dos Anéis, J.R.R. Tolkien
INSERT INTO livro_autor (livro_id, autor_id) VALUES (3, 3); -- Orgulho e Preconceito, Jane Austen
INSERT INTO livro_autor (livro_id, autor_id) VALUES (4, 4); -- Sapiens, Yuval Noah Harari
INSERT INTO livro_autor (livro_id, autor_id) VALUES (5, 5); -- Steve Jobs, Walter Isaacson