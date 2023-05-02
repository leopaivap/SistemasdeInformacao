delimiter $
CREATE TRIGGER tri_atualizaSaldoPoupança
AFTER update
ON conta
FOR EACH ROW
BEGIN
	if(old.senha <> NEW.senha)
	THEN if(new.tipo = "Poupança")
			then SET new.saldo = OLD.saldo + 0.10;
			END if;
	END if;

END$
delimiter ;
