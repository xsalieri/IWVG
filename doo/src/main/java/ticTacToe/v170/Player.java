package ticTacToe.v170;

public class Player {

	private Color color;
	
	private Board board;

	public Player(int player, Board board) {
		assert new ClosedInterval(0,TicTacToe.NUM_PLAYERS-1).includes(player);
		assert board != null;
		color = Color.values()[player];
		this.board = board;
	}

	private void put(String title, Coordinate forbidden) {
		assert board != null;
		assert title != null;
		IO io = new IO();
		Coordinate target = new Coordinate();
		boolean ok;
		do {
			target.read(title);
			ok = board.empty(target);
			if (!ok) {
				io.writeln("Esa casilla no está vacía");
			}
			if (ok && forbidden != null) {
				ok = !target.equals(forbidden);
				if (!ok) {
					io.writeln("No se puede poner de donde se quitó");
				}
			}
		} while (!ok);
		board.put(target, color);
	}

	public void put(String title) {
		assert board != null;
		assert title != null;
		this.put(title, null);
	}

	public void put() {
		assert board != null;
		IO io = new IO();
		io.writeln("Pone el jugador " + color);
		this.put("En");
	}

	public void move() {
		assert board != null;
		IO io = new IO();
		io.writeln("Mueve el jugador " + color);
		Coordinate origin = new Coordinate();
		boolean ok;
		do {
			origin.read("De");
			ok = board.full(origin, color);
			if (!ok) {
				io.writeln("Esa casilla no está ocupada por ninguna de tus fichas");
			}
		} while (!ok);
		board.remove(origin, color);
		this.put("A", origin);
	}

	public void win() {
		new IO().writeln("Victoria!!!! " + color + "! " + color + "! " + color
				+ "! Victoria!!!!");
	}

}
