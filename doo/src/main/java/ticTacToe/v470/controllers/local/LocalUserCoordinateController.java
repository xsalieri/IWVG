package ticTacToe.v470.controllers.local;

import ticTacToe.v470.controllers.CoordinateControllerVisitor;
import ticTacToe.v470.controllers.UserCoordinateController;
import ticTacToe.v470.models.Coordinate;
import ticTacToe.v470.models.Game;

public class LocalUserCoordinateController extends LocalCoordinateController
	implements UserCoordinateController {

	protected LocalUserCoordinateController(Game game) {
		super(game);
	}

	@Override
	public Coordinate getOrigin() {
		return new Coordinate();
	}

	@Override
	public Coordinate getTarget() {
		return new Coordinate();
	}

	@Override
	public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
		coordinateControllerVisitor.visit(this);
	}
	
}
