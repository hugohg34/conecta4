package controller.utils;

import java.util.ArrayList;
import java.util.List;

import model.Board;

public class WinnerChecker {

	List<WinnerRule> winnerRuleList;

	public WinnerChecker(Board board) {
		this.winnerRuleList = new ArrayList<>();
		winnerRuleList.add(new DiagonalWinnerRule(board));
		winnerRuleList.add(new DiagonalInvWinnerRule(board));
		winnerRuleList.add(new HorizontalWinnerRule(board));
		winnerRuleList.add(new VerticalWinnerRule(board));
	}

	public boolean check() {
		for (WinnerRule winnerRule : this.winnerRuleList) {
			if (winnerRule.isFourInLine()) {
				return true;
			}
		}
		return false;
	}
}
