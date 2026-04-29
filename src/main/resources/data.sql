-- =========================
-- CATEGORIAS
-- =========================
INSERT INTO category_entity (id, name) VALUES
                                           (UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000001','-','')), 'Eletrônicos'),
                                           (UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000002','-','')), 'Livros'),
                                           (UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000003','-','')), 'Games'),
                                           (UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000004','-','')), 'Casa');

-- =========================
-- PRODUTOS
-- =========================
INSERT INTO product_entity (id, name, description, price, imgurl) VALUES
                                                                      (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000001','-','')), 'Notebook Gamer RTX 4060', 'Alta performance para jogos e trabalho', 6200.00, 'notebook.png'),
                                                                      (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000002','-','')), 'Livro Java Avançado', 'Programação Java moderna e prática', 149.90, 'java.png'),
                                                                      (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000003','-','')), 'PlayStation 5', 'Console Sony de última geração', 4500.00, 'ps5.png'),
                                                                      (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000004','-','')), 'Fone Bluetooth', 'Som de alta qualidade sem fio', 299.90, 'fone.png'),
                                                                      (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000005','-','')), 'Livro Spring Boot', 'Desenvolvimento backend com Spring', 129.90, 'spring.png');

-- =========================
-- PRODUCT_CATEGORY
-- =========================
INSERT INTO product_category (produto_id, categoria_id) VALUES
                                                            (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000001','-','')), UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000001','-',''))),
                                                            (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000002','-','')), UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000002','-',''))),
                                                            (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000003','-','')), UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000003','-',''))),
                                                            (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000004','-','')), UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000001','-',''))),
                                                            (UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000005','-','')), UNHEX(REPLACE('c1c1c1c1-0000-0000-0000-000000000002','-','')));

-- =========================
-- USUÁRIOS
-- =========================
INSERT INTO user_entity (id, name, email, phone, password, roles) VALUES
                                                                      (UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000001','-','')), 'João Silva', 'joao@email.com', '11999999999', '123456', 'USER'),
                                                                      (UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000002','-','')), 'Maria Souza', 'maria@email.com', '11988888888', '123456', 'ADMIN'),
                                                                      (UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000003','-','')), 'Carlos Lima', 'carlos@email.com', '11977777777', '123456', 'USER');

-- =========================
-- PEDIDOS
-- =========================
INSERT INTO order_entity (id, moment, status, cliente_id) VALUES
                                                              (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000001','-','')), '2026-04-29', 'PAID', UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000001','-',''))),
                                                              (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000002','-','')), '2026-04-28', 'AWAITING_PAYMENT', UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000001','-',''))),
                                                              (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000003','-','')), '2026-04-27', 'SHIPPED', UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000003','-',''))),
                                                              (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000004','-','')), '2026-04-26', 'DELIVERED', UNHEX(REPLACE('u1u1u1u1-0000-0000-0000-000000000002','-','')));

-- =========================
-- ORDER ITEMS
-- =========================
INSERT INTO order_item_entity (order_id, product_id, quantity, price) VALUES
                                                                          (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000001','-','')), UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000001','-','')), 1, 6200.00),
                                                                          (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000001','-','')), UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000004','-','')), 2, 299.90),
                                                                          (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000002','-','')), UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000002','-','')), 1, 149.90),
                                                                          (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000003','-','')), UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000003','-','')), 1, 4500.00),
                                                                          (UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000004','-','')), UNHEX(REPLACE('p1p1p1p1-0000-0000-0000-000000000005','-','')), 3, 129.90);

-- =========================
-- PAGAMENTOS
-- =========================
INSERT INTO payment_entity (id, moment, order_id) VALUES
                                                      (UNHEX(REPLACE('pay1pay1-0000-0000-0000-000000000001','-','')), NOW(), UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000001','-',''))),
                                                      (UNHEX(REPLACE('pay1pay1-0000-0000-0000-000000000002','-','')), NOW(), UNHEX(REPLACE('o1o1o1o1-0000-0000-0000-000000000004','-','')));