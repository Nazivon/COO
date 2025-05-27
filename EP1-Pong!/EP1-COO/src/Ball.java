import java.awt.*;
import java.util.Random;

/**
 Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
 instancia um objeto deste tipo quando a execução é iniciada.
 */

public class Ball {

	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private double speed;

	private double eixoX;
	private double eixoY;

	/**
	 Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola
	 (em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada
	 aleatóriamente pelo construtor.

	 @param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
	 @param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
	 @param width largura do retangulo que representa a bola.
	 @param height altura do retangulo que representa a bola.
	 @param color cor da bola.
	 @param speed velocidade da bola (em pixels por millisegundo).
	 */

	public Ball (double cx, double cy, double width, double height, Color color, double speed) {
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;

		double angulo = aleatorio();
		this.eixoX = this.speed*(Math.cos(angulo));
		this.eixoY = this.speed*(Math.sin(angulo));
	}

	private double aleatorio() {
		Random random = new Random();
		double anguloB;
		double senoB;
		do {
			int anguloA = random.nextInt(360);
			anguloB = Math.toRadians(anguloA);
			senoB = Math.sin(anguloB);
		} while (Math.abs(senoB) > 0.939);
		return anguloB;
	}

	/**
	 Método chamado sempre que a bola precisa ser (re)desenhada.
	 */

	public void draw() {
		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	/**
	 Método chamado quando o estado (posição) da bola precisa ser atualizado.

	 @param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	 */

	public void update (long delta) {
		this.cx += (delta*this.eixoX);
		this.cy += (delta* this.eixoY);
	}

	/**
	 Método chamado quando detecta-se uma colisão da bola com um jogador.

	 @param playerId uma string cujo conteúdo identifica um dos jogadores.
	 */

	public void onPlayerCollision(String playerId) {
		if (playerId.equals("Player 1")) {
			this.eixoX = Math.abs(this.eixoX);
		}
		else if (playerId.equals("Player 2")) {
			this.eixoX = -(Math.abs(this.eixoX));
		}
	}

	/**
	 Método chamado quando detecta-se uma colisão da bola com uma parede.

	 @param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	 */

	public void onWallCollision(String wallId) {
		if (wallId.equals("Left")) {
			this.eixoX = Math.abs(this.eixoX);
		} else if (wallId.equals("Right")) {
			this.eixoX = -(Math.abs(this.eixoX)); }
        else if (wallId.equals("Top")) {
			this.eixoY = Math.abs(this.eixoY); }
		else if (wallId.equals("Bottom")) {
			this.eixoY = -(Math.abs(this.eixoY));
		}
	}

	/**
	 Método que verifica se houve colisão da bola com uma parede.

	 @param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
	 @return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	 */

	public boolean checkCollision (Wall wall) {
		String nomeW = wall.getId();
		if (nomeW.equals("Left")) {
			double wallL = wall.getCx() + (wall.getWidth() / 2);
			if (((this.cx - this.width/2) <= wallL) && (this.eixoX < 0)) return true;
		}
		else if (nomeW.equals("Right")) {
			double wallR = wall.getCx() - (wall.getWidth() / 2);
			if (((this.cx + this.width/2) >= wallR) && (this.eixoX > 0)) return true;
		}
		else if (nomeW.equals("Top")) {
			double wallT = wall.getCy() + (wall.getHeight() / 2);
			if (((this.cy - this.height/2) <= wallT) && (this.eixoY < 0)) return true;
		}
		else if (nomeW.equals("Bottom")) {
			double wallB =  wall.getCy() - (wall.getHeight() / 2);
			if (((this.cy + this.height/2) >= wallB) && (this.eixoY > 0)) return true;
		}
		return false;
	}

	/**
	 Método que verifica se houve colisão da bola com um jogador.

	 @param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
	 @return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	 */

	public boolean checkCollision (Player player) {
		double CyP = player.getCy();
		double HeightP = player.getHeight();

		double topoP = CyP - HeightP/2;
		double fundoP = CyP + HeightP/2;

		boolean ver1 = ((this.cy - (this.height / 2) < fundoP) && (this.cy + (this.height / 2) > topoP));
		boolean ver2;
		boolean ver3;

		if (player.getId().equals("Player 1")) {
			ver2 = ((this.cx - this.width / 2 <= 90.0) && (this.cx + this.width / 2 > 90.0));
			ver3 = (this.eixoX < 0);
		}
		else {
			ver2 = ((this.cx + this.width / 2 >= 710.0) && (this.cx - this.width / 2 < 710.0));
			ver3 = (this.eixoX > 0);
		}

		return (ver1 && ver2 && ver3);
	}

	/**
	 Método que devolve a coordenada x do centro do retângulo que representa a bola.
	 @return o valor double da coordenada x.
	 */

	public double getCx() {
		return this.cx;
	}

	/**
	 Método que devolve a coordenada y do centro do retângulo que representa a bola.
	 @return o valor double da coordenada y.
	 */

	public double getCy() {
		return this.cy;
	}

	/**
	 Método que devolve a velocidade da bola.
	 @return o valor double da velocidade.

	 */

	public double getSpeed() {
		return this.speed;
	}
}