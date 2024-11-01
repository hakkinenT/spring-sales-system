CREATE FUNCTION calculate_total() RETURNS trigger AS $$
  DECLARE
  	total_sale NUMERIC(10,2);
  BEGIN
  	SELECT SUM(subtotal) INTO total_sale
	FROM tb_sale_item
	WHERE sale_id = NEW.sale_id;

    UPDATE tb_sale
    SET total = total_sale
    WHERE id = NEW.sale_id;

    RETURN NEW;
  END
$$ LANGUAGE plpgsql;


CREATE TRIGGER
  trigger_calculate_total
AFTER INSERT OR UPDATE ON
  tb_sale_item
FOR EACH ROW EXECUTE PROCEDURE
  calculate_total();