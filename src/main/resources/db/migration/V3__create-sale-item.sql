CREATE TABLE tb_sale_item(
	product_id BIGINT NOT NULL,
	sale_id BIGINT NOT NULL,
	quantity INTEGER DEFAULT 0,
	subtotal NUMERIC(10, 2) DEFAULT 0.00,
	PRIMARY KEY(product_id, sale_id),
	FOREIGN KEY (product_id) REFERENCES tb_product(id),
	FOREIGN KEY (sale_id) REFERENCES tb_sale(id)
);