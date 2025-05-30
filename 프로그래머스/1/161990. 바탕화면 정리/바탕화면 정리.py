def solution(wallpaper):
    min_row = 51
    min_col = 51
    max_row = 0
    max_col = 0
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                min_row = min(min_row, i)
                min_col = min(min_col, j)
                max_row = max(max_row, i+1)
                max_col = max(max_col, j+1)
    return [min_row, min_col, max_row, max_col]