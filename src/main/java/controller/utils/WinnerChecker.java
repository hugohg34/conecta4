package controller.utils;

import java.util.ArrayList;
import java.util.List;

import model.Board;

public class WinnerChecker {

	List<WinnerRule> winnerRuleList;

	public WinnerChecker(Board board) {
		this.winnerRuleList = new ArrayList<>();
		this.winnerRuleList.add(new DiagonalWinnerRule(board));
		this.winnerRuleList.add(new DiagonalInvWinnerRule(board));
		this.winnerRuleList.add(new HorizontalWinnerRule(board));
		this.winnerRuleList.add(new VerticalWinnerRule(board));
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
