BEGIN
	if(NEW.qntdEstoque < 5 AND NEW.nomeProduto LIKE "Vara de bambu")
		then
				SET @mensagem = CONCAT("Estoque minimo atingido: ", NEW.nomeProduto, " - Estoque:", NEW.qntdEstoque);
				
				INSERT INTO auditoria VALUES(NULL, @mensagem, "produto",NOW(), USER());
	END if;
END