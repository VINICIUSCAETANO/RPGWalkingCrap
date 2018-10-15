package local.model;

import java.util.List;
import local.exception.NomePersonagemException;
import local.exception.PersonagemException;
import local.exception.VidaException;
import local.template.PersonagemDAO;

/*
import local.exception.NomePersonagemException;
import local.exception.PersonagemException;
import local.exception.VidaException;
import local.template.PersonagemDAO;
 */
public abstract class Personagem implements PersonagemDAO {

    protected String nome;
    protected int forca;
    protected int habilidadeMental;
    protected int poderDeAtaque;
    protected int esquiva;
    protected int resistencia;
    protected int vidaAtual;
    protected int vidaMaxima;

    public abstract void atacar(Personagem oponente);

    public abstract void contraAtacar(Personagem oponente);

    public abstract void aprimorarHabilidadePrincipal();

    public abstract void regenerarVida();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() >= 11 && nome.length() <= 30) {
            this.nome = nome;
        } else {
            throw new NomePersonagemException("Nome inválido");
        }
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        if (esquiva >= 0 && esquiva <= 99) {
            this.esquiva = esquiva;
        } else {
            throw new PersonagemException("Dado de entrada inválido");
        }
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        if (resistencia >= 0 && resistencia <= 99) {
            this.resistencia = resistencia;
        } else {
            throw new PersonagemException("Dado de entrada inválido");
        }
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) throws VidaException {
        if (vidaAtual > 0) {
            this.vidaAtual = vidaAtual;
        } else {
            throw new VidaException("O Personagem está morto");
        }
    }

    public boolean salvar() {
        return true;
    }

    public List<Personagem> buscarTodos() {
        return null;
    }

    public Personagem buscar(Personagem in) {
        return null;
    }    
}
