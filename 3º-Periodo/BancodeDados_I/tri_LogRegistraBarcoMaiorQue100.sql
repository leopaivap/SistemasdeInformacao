BEGIN
	
	if(NEW.precoCusto > 100 && !(NEW.Categoria_codCategoria != 12))
		then 
			SET @mensagem = CONCAT("Barco com custo maior que 100: ", NEW.nomeProduto, " - Preço:", NEW.precoCusto);
			
			INSERT INTO auditoria
			VALUES(NULL, @mensagem, "produto",NOW(), USER());
	END if;
	
END