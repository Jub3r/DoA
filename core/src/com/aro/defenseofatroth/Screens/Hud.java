package com.aro.defenseofatroth.Screens;

import com.aro.defenseofatroth.Tools.Constants;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.aro.defenseofatroth.Tools.Constants.VIRTUAL_HEIGHT;
import static com.aro.defenseofatroth.Tools.Constants.VIRTUAL_WIDTH;
import static com.badlogic.gdx.graphics.Color.BLACK;

/**
 * Created by elementary on 7/04/16.
 */
public class Hud {

    public Stage stage;
    private Viewport viewport;

    private int score;
    private int wave;
    private int money;

    Label userName;
    Label moneyTextLabel;
    Label waveTextLabel;

    Label scoreLabel;
    Label moneyLabel;
    Label waveLabel;

    public Hud(SpriteBatch spriteBatch) {

        score = 0;
        wave = 0;
        money = 0;

        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        userName = new Label(LoginScreen.userName, new Label.LabelStyle(new BitmapFont(), BLACK));
        moneyTextLabel = new Label("Oro", new Label.LabelStyle(new BitmapFont(), BLACK));
        waveTextLabel = new Label("Oleada", new Label.LabelStyle(new BitmapFont(), BLACK));

        scoreLabel = new Label(String.format("%08d", score), new Label.LabelStyle(new BitmapFont(), BLACK));
        waveLabel = new Label(String.format("%02d", wave), new Label.LabelStyle(new BitmapFont(), BLACK));
        moneyLabel = new Label(String.format("%08d", money), new Label.LabelStyle(new BitmapFont(), BLACK));

        userName.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);
        moneyTextLabel.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);
        waveTextLabel.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);

        scoreLabel.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);
        waveLabel.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);
        moneyLabel.setFontScale(VIRTUAL_WIDTH / 500, VIRTUAL_HEIGHT / 500);

        table.add(userName).expandX().padTop(VIRTUAL_WIDTH / 100);
        table.add(waveTextLabel).expandX().padTop(VIRTUAL_WIDTH / 100);
        table.add(moneyTextLabel).expandX().padTop(VIRTUAL_WIDTH / 100);

        table.row();

        table.add(scoreLabel).expandX();
        table.add(waveLabel).expandX();
        table.add(moneyLabel).expandX();

        stage.addActor(table);

    }
}
