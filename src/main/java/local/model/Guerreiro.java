package local.model;


import local.util.Util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.exception.VidaException;

public class Guerreiro extends Personagem{

    public Guerreiro(String nome) {
        //this.nome = nome + " Warrior";
        setNome(String.format("%s Warrior", nome));
        this.forca = Util.random(1,1000);
        this.habilidadeMental = 0;
        this.poderDeAtaque = this.forca*10;
        this.esquiva = Util.random(0,50);
        this.resistencia = Util.random(0,90);
        this.vidaMaxima = Util.random(1,40000);
        try {
            setVidaAtual(Util.random(1,40000));
        } catch (VidaException ex) {
            
        }
    }

    @Override
    public void atacar(Personagem oponente){
       ataque(oponente);
        if(oponente.vidaAtual>0){
            oponente.contraAtacar(this);
        }
    }
    public void contraAtacar(Personagem oponente){
        ataque(oponente);
    }

    public void aprimorarHabilidadePrincipal(){
        this.poderDeAtaque = (int)(this.poderDeAtaque * 1.1);
    }

    public void regenerarVida(){
        this.vidaAtual = this.vidaAtual + (int)(this.vidaMaxima*0.05);
        if(this.vidaAtual>this.vidaMaxima){
            this.vidaAtual = this.vidaMaxima;
        }
    }

    private void ataque(Personagem oponente){
        boolean hit = Util.random(0,100) < oponente.esquiva;
        if(hit){
            oponente.vidaAtual = oponente.vidaAtual -
                    (poderDeAtaque - (oponente.resistencia/100)*oponente.vidaAtual);
        }
    }
}
