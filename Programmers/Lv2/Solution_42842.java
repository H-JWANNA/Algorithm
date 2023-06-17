package Lv2;

class Solution {
	public int[] solution(int brown, int yellow) {
        /*
            brown => (가로 + 세로 - 2) * 2
            yellow => (가로 - 2) * (세로 - 2)
        */

		int all = brown + yellow;
		int half = (int) Math.pow(all, 0.5);

		for(int i = 3; i <= half; i++) {
			if (all % i != 0) {
				continue;
			}

			int[] size = new int[] {all / i, i};
			if (isYellow(size, yellow)) {
				return size;
			}
		}

		return new int[] {-1, -1};
	}

	private boolean isYellow(int[] size, int yellow) {
		return (size[0] - 2) * (size[1] - 2) == yellow;
	}
}
