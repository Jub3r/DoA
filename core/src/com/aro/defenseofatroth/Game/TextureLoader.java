package com.aro.defenseofatroth.Game;

import com.aro.defenseofatroth.MainClass;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Esta clase se encarga de cargar las texturas en memoria, de tal forma que no se cargen varias
 * veces la misma textura en la GPU por diferentes unidades. Tambien es la encargada de cargar lo
 * necesario en memoria antes de que empiece el nivel.
 * Created by Sergio on 17/04/2016.
 */
public class TextureLoader implements Disposable{
    World mundo; //lo tengo para darselo a las Factorias
    Stage escenario; //lo tengo para darselo a las Factorias

    private TextureAtlas barrasVida; //las barras de vida (pueden ir en otro atlas , solo son 2)
    private TextureAtlas torres; //las torres del juego
    private TextureAtlas proyectiles; //los proyectiles del juego
    private TextureAtlas enemigos; //los enemigos del juego
    private Animation basicTankHoriz;
    private Texture mejora;
    private BitmapFont font;

    //TODO pasar esto a atlas
    private TextureRegion niapa;
    private TextureRegion proyniapa;
    private TextureRegion misil;

    //Animaciones

    public Animation getBasicTankHoriz() {
        return basicTankHoriz;
    }





    //Se deberia de usar un asert manager para mostrar una barra de carga
    public void cargar(){
        //TODO hacer. Aqui se cargarian los atlas  caveman.atlas
        barrasVida=MainClass.getManager().get("barrasVida.atlas", TextureAtlas.class);
        TextureAtlas atextura = MainClass.getManager().get("caveman.atlas", TextureAtlas.class);
        Array<TextureAtlas.AtlasRegion> anima = new Array<TextureAtlas.AtlasRegion>(atextura.getRegions());
        basicTankHoriz=new Animation(0.05f, anima, Animation.PlayMode.LOOP);
        niapa=new TextureRegion(anima.get(1));
        proyniapa=new TextureRegion(MainClass.getManager().get("barraRoja.png", Texture.class));
        misil=new TextureRegion(MainClass.getManager().get("barraVerde.png", Texture.class));
        font=new BitmapFont(Gdx.files.internal("data/default.fnt"),Gdx.files.internal("data/default.png"), false);
        mejora=MainClass.getManager().get("mejorar.png", Texture.class);
    }

    public TextureRegion obtenerBarraRoja(){
        return barrasVida.findRegion("barraRoja");
    }
    public TextureRegion obtenerBarraVerde(){
        return barrasVida.findRegion("barraVerde");
    }


    public Stage getEscenario() {
        return escenario;
    }

    public void setEscenario(Stage escenario) {
        this.escenario = escenario;
    }

    public World getMundo() {
        return mundo;
    }

    public void setMundo(World mundo) {
        this.mundo = mundo;
    }

    public void niapadePrueba(TextureRegion torre,Texture proyectil){
        this.niapa=torre;
    }

    public TextureRegion obtenerMissile(){
        return misil;
    }

    @Override
    public void dispose() {
        barrasVida.dispose();
        if (enemigos!=null){
            enemigos.dispose();
            enemigos=null;
        }
        if (torres!=null) {
            torres.dispose();
            torres=null;
        }
        if (proyectiles!=null){
            proyectiles.dispose();
            proyectiles=null;
        }
        if (font!=null){
            font.dispose();
            font=null;
        }
        if (mejora!=null){
            mejora.dispose();
            mejora=null;
        }
    }

    public TextureRegion obtenerBasicTower(){
        //TODO hacer. Debe devolver un tankeBasico
        return niapa;
    }
    public TextureRegion obtenerProyectilBasicTower(){
        //TODO hacer

        return new TextureRegion(proyniapa);
    }
}
