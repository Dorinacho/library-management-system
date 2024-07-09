-- Insert authors
INSERT INTO authors (id, first_name, last_name, bio) VALUES
('4b1e7e1d-7b7b-4f4b-85b6-4a2b3f4a1f3b', 'John', 'Doe', 'An experienced author of mystery novels.'),
('7e2f8c2a-3c2f-4879-9675-8c3b1d2e4f7c', 'Jane', 'Smith', 'A renowned writer of science fiction.'),
('a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b', 'Emily', 'Johnson', 'A popular author of romance novels.');

-- Insert books for John Doe
INSERT INTO books (id, title, description, isbn, author_id) VALUES
('b9f6d0e1-8c4b-4976-a7c4-6d5f8e2f1c3b', 'Mystery at the Manor', 'A thrilling mystery novel.', '978-3-16-148410-0', '4b1e7e1d-7b7b-4f4b-85b6-4a2b3f4a1f3b'),
('c1e7a2d3-5b7d-4b9a-8c6b-3d5f9e4a7c2b', 'The Hidden Secret', 'Another captivating mystery story.', '978-1-61-729494-5', '4b1e7e1d-7b7b-4f4b-85b6-4a2b3f4a1f3b'),
('d3a8c7f2-4d3b-4e6a-9d2b-7f5a8e3c4b1d', 'Whispers in the Dark', 'A suspenseful mystery novel.', '978-0-07-161586-1', '4b1e7e1d-7b7b-4f4b-85b6-4a2b3f4a1f3b');

-- Insert books for Jane Smith
INSERT INTO books (id, title, description, isbn, author_id) VALUES
('e4f8b7a3-5c4d-4879-9b2d-8c6a7f3d1e2f', 'Journey to the Stars', 'An epic science fiction adventure.', '978-0-262-03384-8', '7e2f8c2a-3c2f-4879-9675-8c3b1d2e4f7c'),
('f5d7c9e2-6b8a-4c5d-8d7a-2b3e9f1a4d6c', 'Alien Encounter', 'A thrilling story of first contact.', '978-0-13-110362-7', '7e2f8c2a-3c2f-4879-9675-8c3b1d2e4f7c'),
('a6c8d2e3-7b4d-4a5b-9c8d-1d2e8f3a7c9f', 'Time Warp', 'A fascinating tale of time travel.', '978-0-596-52068-7', '7e2f8c2a-3c2f-4879-9675-8c3b1d2e4f7c'),
('b7e8a3d4-8c2b-4f7d-9b8a-3d5f9e6c4a1d', 'Galactic Wars', 'An action-packed space opera.', '978-0-521-85033-3', '7e2f8c2a-3c2f-4879-9675-8c3b1d2e4f7c');

-- Insert books for Emily Johnson
INSERT INTO books (id, title, description, isbn, author_id) VALUES
('c8f9b1a2-9c3d-4e7a-8b2d-5d4a7e2f9b1c', 'Love in Bloom', 'A touching romance novel.', '978-0-7653-4512-4', 'a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b'),
('d9a1c7e3-8b5d-4a6b-9d7c-2e3a8f5d1c4b', 'Hearts Entwined', 'A beautiful story of love and passion.', '978-1-250-30381-0', 'a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b'),
('e1b2d8c4-7c6a-4f5d-8d7a-1c3e9f2a7b8d', 'Eternal Flame', 'A romance novel that will melt your heart.', '978-1-5011-5799-8', 'a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b'),
('f2d3e9b5-6a7d-4b8a-9c2d-3b4e1f6a8d7c', 'Passionate Embrace', 'A story of love and desire.', '978-1-4516-7321-1', 'a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b'),
('a3b4c1e6-5d8a-4f6b-8c7d-2e3a9f7b1c5d', 'Whispers of Love', 'A romantic tale that will leave you breathless.', '978-1-4767-7267-0', 'a8c3f2d6-6a5f-4d3c-9d7e-5b2c4f7e8a1b');
