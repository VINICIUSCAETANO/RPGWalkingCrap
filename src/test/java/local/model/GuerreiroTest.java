package local.model;

import local.exception.NomePersonagemException;
import local.exception.PersonagemException;
import local.exception.VidaException;
import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;



public class GuerreiroTest {

    @Before
    public void setUp(){

    }

    @Test
    public void validaTamanhoMinimoNome() {
        try {
            Personagem x = new Guerreiro("Ze");
            fail("Um nome com dois caracteres não deveria ter sido permitido");
        }catch (NomePersonagemException ex){
            assertThat(ex.getMessage(),is(equalTo("Nome inválido")));
        }
    }

    @Test
    public void validaTamanhoMinimoNomeAceitavel() {
            Personagem x = new Guerreiro("Luz");
            assertThat(x.getNome(),is(equalTo("Luz Warrior")));
    }

    @Test
    public void validaTamanhoMaximoNome() {
        try {
            Personagem x = new Guerreiro(RandomString.make(23));
            fail("Um nome com 31 caracteres não deveria ter sido permitido");
        }catch (NomePersonagemException ex){
            assertThat(ex.getMessage(),is(equalTo("Nome inválido")));
        }
    }
    @Test
    public void validaTamanhoMaximoNomeAceitavel() {
        String nome = RandomString.make(22);
        Personagem x = new Guerreiro(nome);
        assertThat(x.getNome(), is(equalTo(nome+" Warrior")));

    }

    @Test
    public void validaVidaAtualMinimaPermitida(){
        Personagem x = new Guerreiro("Angelo");
        try {
            x.setVidaAtual(1);
            assertThat(x.getVidaAtual(), is(equalTo(1)));
        }catch (VidaException ex){
            fail("Deveria ter aceitado a vida");
        }
    }

    @Test
    public void validaVidaAtualMaximaPermitida(){
        Personagem x = new Guerreiro("Angelo");
        try{
        x.setVidaAtual(100);
        assertThat(x.getVidaAtual(),is(equalTo(100)));
    }catch (VidaException ex){
        fail("Deveria ter aceitado a vida");
    }
    }

    @Test
    public void validaVidaAtualMinimaNaoPermitida(){
        Personagem x = new Guerreiro("Angelo");
        try{
        x.setVidaAtual(0);
        fail("Não deveria ter aceitado o valor de vida atual");
        }catch (VidaException ex){
            assertThat(ex.getMessage(),is(equalTo("O Personagem está morto")));
        }
    }

    @Test
    public void validaResistenciaLimiteAceitavel(){
        Personagem p = new Guerreiro("Zezão");
        p.setResistencia(99);
        assertThat(p.getResistencia(),is(equalTo(99)));
    }
    @Test
    public void validaResistenciaBaseAceitavel(){
        Personagem p = new Guerreiro("Zezão");
        p.setResistencia(0);
        assertThat(p.getResistencia(),is(equalTo(0)));
    }
    @Test
    public void validaResistenciaBaseNaoAceitavel(){
        Personagem p = new Guerreiro("Zezão");
        try {
            p.setResistencia(-1);
            fail("Não deveria aceitar um valor menor do que 0");
        }catch (PersonagemException ex) {
            assertThat(ex.getMessage(),is(equalTo("Dado de entrada inválido")));
        }
    }

    @Test
    public void validaResistenciaLimiteNaoAceitavel(){
        Personagem p = new Guerreiro("Zezão");
        try {
            p.setResistencia(100);
            fail("Não deveria aceitar um valor menor do que 0");
        }catch (PersonagemException ex) {
            assertThat(ex.getMessage(),is(equalTo("Dado de entrada inválido")));
        }
    }

    @Test
    public void validaEsquivaBaseAceitavel(){
        Personagem p = new Guerreiro("Snow");
        p.setEsquiva(0);
        assertThat(p.getEsquiva(),is(equalTo(0)));
    }

    @Test
    public void validaEsquivaBaseNaoAceitavel(){
        Personagem p = new Guerreiro("Snow");
        try {
            p.setEsquiva(-1);
        }catch (PersonagemException ex) {
            assertThat(ex.getMessage(), is(equalTo("Dado de entrada inválido")));
        }
    }

    @Test
    public void validaEsquivaLimiteNaoAceitavel(){
        Personagem p = new Guerreiro("Snow");
        try {
            p.setEsquiva(100);
        }catch (PersonagemException ex) {
            assertThat(ex.getMessage(), is(equalTo("Dado de entrada inválido")));
        }
    }

    @Test
    public void validaEsquivaLimiteAceitavel(){
        Personagem p = new Guerreiro("Snow");
        p.setEsquiva(99);
        assertThat(p.getEsquiva(),is(equalTo(99)));
    }

    @Test
    public void validaNomePersonagemException(){
        NomePersonagemException x = new NomePersonagemException("Uma mensagem");
        assertTrue(x instanceof PersonagemException);
    }
    @Test
    public void validaPersonagemException(){
        PersonagemException x = new PersonagemException("Uma mensagem");
        assertTrue(x instanceof RuntimeException);
    }

    @Test
    public void validaVidaException(){
        VidaException x = new VidaException("Uma mensagem");
        assertTrue(x instanceof IOException);
    }

    @Test
    public void validaPersonagemSendoDAO(){
        Personagem x = new Guerreiro("Angelo");
        assertTrue(x instanceof local.template.PersonagemDAO);
    }

    @Test
    public void validaPersistenciaPersonagem(){
        Personagem x = new Guerreiro("Angelo");
        boolean p = x.salvar();
        assertTrue(p);
    }

    @Test
    public void validaBuscaPersonagem(){
        Personagem x = new Guerreiro("Luz");
        x.salvar();
        Personagem y = new Guerreiro("Luz");
        Personagem p = x.buscar(y);
        assertThat(p.getNome(),is("Luz Warrior"));
    }

    @Test
    public void validaBuscaPersonagemInexistente(){
        Personagem x = new Guerreiro(RandomString.make(14));
        Personagem p = x.buscar(x);
        assertNull(p);
    }
}