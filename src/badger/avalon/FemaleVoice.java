package badger.avalon;

public class FemaleVoice implements Voice {

	@Override
	public int getStart() {
		return R.raw.female_start;
	}

	@Override
	public int getFinalReset() {
		return R.raw.female_final_reset;
	}

	@Override
	public int getGuinevereReset() {
		return R.raw.female_guinevere_reset;
	}

	@Override
	public int getGuinevere() {
		return R.raw.female_guinevere;
	}

	@Override
	public int getLancelotReset() {
		return R.raw.female_lancelot_reset;
	}

	@Override
	public int getLancelot() {
		return R.raw.female_lancelot;
	}

	@Override
	public int getMerlinNoMordred() {
		return R.raw.female_merlin_no_mordrid_no_lance;
	}

	@Override
	public int getMerlinYesMordred() {
		return R.raw.female_merlin_yes_mordrid_no_lance;
	}

	@Override
	public int getMerlinReset() {
		return R.raw.female_reset;
	}

	@Override
	public int getMinionNoLancelotNoOberon() {
		return R.raw.female_minion_no_lance_no_oberon;
	}

	@Override
	public int getMinionNoLancelotYesOberon() {
		return R.raw.female_minion_no_lance_yes_oberon;
	}

	@Override
	public int getMinionReset() {
		return R.raw.female_minion_reset;
	}

	@Override
	public int getMinionYesLancelotNoOberon() {
		return R.raw.female_minion_yes_lance_no_oberon;
	}

	@Override
	public int getMinionYesLancelotYesOberon() {
		return R.raw.female_minion_yes_lance_yes_oberon;
	}

	@Override
	public int getPercivalNoMorganna() {
		return R.raw.female_percival_no_morganna;
	}

	@Override
	public int getPercivalYesMorganna() {
		return R.raw.female_percival_yes_morganna;
	}

	@Override
	public int getPercivalReset() {
		return R.raw.female_reset;
	}

}
