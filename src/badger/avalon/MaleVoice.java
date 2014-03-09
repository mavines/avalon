package badger.avalon;

import android.content.Context;

public class MaleVoice implements Voice {

	@Override
	public int getStart() {
		return R.raw.start;
	}

	@Override
	public int getFinalReset() {
		return R.raw.final_reset;
	}

	@Override
	public int getGuinevereReset() {
		return R.raw.guinevere_reset;
	}

	@Override
	public int getGuinevere() {
		return R.raw.guinevere;
	}

	@Override
	public int getLancelotReset() {
		return R.raw.lancelot_reset;
	}

	@Override
	public int getLancelot() {
		return R.raw.lancelot;
	}

	@Override
	public int getMerlinNoMordred() {
		return R.raw.merlin_no_mordred;
	}

	@Override
	public int getMinionNoLancelotNoOberon() {
		return R.raw.minion_no_oberon_no_lancelot;
	}

	@Override
	public int getMinionNoLancelotYesOberon() {
		return R.raw.minion_yes_oberon_no_lancelot;
	}

	@Override
	public int getMinionReset() {
		return R.raw.minion_reset;
	}

	@Override
	public int getMinionYesLancelotNoOberon() {
		return R.raw.minion_no_oberon_yes_lancelot;
	}

	@Override
	public int getMinionYesLancelotYesOberon() {
		return R.raw.minion_yes_oberon_yes_lancelot;
	}

	@Override
	public int getPercivalNoMorganna() {
		return R.raw.percival_no_morganna;
	}

	@Override
	public int getPercivalYesMorganna() {
		return R.raw.percival_yes_morganna;
	}

	@Override
	public int getMerlinYesMordred() {
		return R.raw.merlin_yes_mordred;
	}

	@Override
	public int getMerlinReset() {
		return R.raw.merlin_reset;
	}

	@Override
	public int getPercivalReset() {
		return R.raw.percival_reset;
	}
}
