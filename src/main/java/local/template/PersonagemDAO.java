/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.template;

import java.util.List;
import local.model.Personagem;

/**
 *
 * @author Vinicius
 */
public interface PersonagemDAO {
    public boolean salvar();
    public List <Personagem> buscarTodos();
    public Personagem buscar(Personagem in);
}
