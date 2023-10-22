function solution(maps) {
  const dr = [0, 0, -1, 1]; // 상, 하, 좌, 우
  const dc = [1, -1, 0, 0]; // 상, 하, 좌, 우
  const n = maps.length;
  const m = maps[0].length;
  const visited = Array.from({ length: n }, () => Array(m).fill(false));

  const queue = [];
  queue.push([0, 0, 1]); // x좌표, y좌표, 거리

  while (queue.length > 0) {
    const [x, y, distance] = queue.shift();

    if (x === n - 1 && y === m - 1) return distance;

    for (let i = 0; i < 4; i++) {
      const nx = x + dr[i];
      const ny = y + dc[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if (maps[nx][ny] === 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny, distance + 1]);
        }
      }
    }
  }
  return -1;
}