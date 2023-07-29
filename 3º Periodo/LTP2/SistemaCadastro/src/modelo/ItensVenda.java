/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tulio
 */
public class ItensVenda implements Serializable{
    private Integer idItensVenda;
    private Integer quantidadeProduto;
    private Produto objProduto;
    private Venda objVenda;

    public ItensVenda() {
    }

    public Produto getObjProduto() {
        return objProduto;
    }

    public void setObjProduto(Produto objProduto) {
        this.objProduto = objProduto;
    }

    public Venda getObjVenda() {
        return objVenda;
    }

    public void setObjVenda(Venda objVenda) {
        this.objVenda = objVenda;
    }

    public Integer getIdItensVenda() {
        return idItensVenda;
    }

    public void setIdItensVenda(Integer idItensVenda) {
        this.idItensVenda = idItensVenda;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idItensVenda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensVenda other = (ItensVenda) obj;
        if (!Objects.equals(this.idItensVenda, other.idItensVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return objProduto.getDescricao()+" Valor: "+objProduto.getValor()+" Quant.: "+String.valueOf(quantidadeProduto); 
    }

    
   
    
    
}
