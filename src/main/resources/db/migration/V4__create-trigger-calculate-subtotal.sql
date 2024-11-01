CREATE FUNCTION calculate_subtotal() RETURNS trigger AS $$
  DECLARE
  	product_price NUMERIC(10,2);
  BEGIN
  	SELECT price INTO product_price
	FROM tb_product
	WHERE tb_product.id = NEW.product_id;

    NEW.subtotal := product_price * NEW.quantity;

    RETURN NEW;
  END
$$ LANGUAGE plpgsql;


CREATE TRIGGER
  trigger_calculate_subtotal
BEFORE INSERT OR UPDATE ON
  tb_sale_item
FOR EACH ROW EXECUTE PROCEDURE
  calculate_subtotal();