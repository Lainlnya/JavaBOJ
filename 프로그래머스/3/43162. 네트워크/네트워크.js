function solution(n, computers) {
  let network = [];
  let visited = [];

  // 초기화
  for (let i = 0; i <= n; i++) {
    network[i] = [];
    visited[i] = false;
  }

  for (let i = 0; i < computers.length; i++) {
    for (let j = 0; j < n; j++) {
      if (i !== j) {
        if (computers[i][j] === 1) {
          network[i + 1].push(j + 1);
        }
      }
    }
  }

  let groups = 0;

  for (let i = 1; i <= n; i++) {
    if (!visited[i]) {
      dfs(i, network, visited);
      groups++;
    }
  }

  return groups;
}

function dfs(num, network, visited) {
  if (visited[num]) return;

  visited[num] = true;

  let neighbors = network[num];
  for (let i = 0; i < neighbors.length; i++) {
    dfs(neighbors[i], network, visited);
  }
}