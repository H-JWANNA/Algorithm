package Lv3;

import java.util.*;

public class Solution_81303 {
	public String solution(int n, int k, String[] cmd) {
		StringTokenizer st;

		Stack<Node> stack = new Stack<>();
		int[] pre = new int[n];
		int[] next = new int[n];

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++) {
			pre[i] = i - 1;
			next[i] = i + 1;
			sb.append('O');
		}

		for(String s : cmd) {
			st = new StringTokenizer(s);
			int num;

			switch(st.nextToken()) {

				case "U":
					num = Integer.parseInt(st.nextToken());

					while(num-- > 0) {
						k = pre[k];
					}

					break;

				case "D":
					num = Integer.parseInt(st.nextToken());

					while(num-- > 0) {
						k = next[k];
					}

					break;

				case "C":
					// 현재 노드 삭제
					stack.push(new Node(pre[k], k, next[k]));

					// 앞 뒤 노드 서로 연결
					if (pre[k] != -1) {
						next[pre[k]] = next[k];
					}

					if (next[k] != n) {
						pre[next[k]] = pre[k];
					}

					// 삭제된 위치 표시
					sb.setCharAt(k, 'X');

					// K 위치 재조정 (마지막 행인 경우 pre, 아니면 next)
					if (next[k] == n) {
						k = pre[k];
					} else {
						k = next[k];
					}

					break;

				case "Z":
					// 복구할 노드 pop
					Node node = stack.pop();

					// 앞 뒤 노드 서로 연결
					if (node.pre != -1) {
						next[node.pre] = node.cur;
					}

					if (node.next != n) {
						pre[node.next] = node.cur;
					}

					// 복구한 위치 표시
					sb.setCharAt(node.cur, 'O');

					break;
			}
		}

		return sb.toString();
	}

	static class Node {
		int pre, cur, next;

		public Node(int pre, int cur, int next) {
			this.pre = pre;
			this.cur = cur;
			this.next = next;
		}
	}
}
