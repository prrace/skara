        var extendedHeaders = List.of(
            "old mode ",
            "new mode ",
            "deleted file mode ",
            "new file mode ",
            "copy from ",
            "copy to ",
            "rename from ",
            "rename to ",
            "similarity index ",
            "dissimilarity index ",
            "index "
        );
        while (i < lines.size()) {
            var line = lines.get(i);
            if (extendedHeaders.stream().noneMatch(h -> line.startsWith(h))) {
                break;
            }
            i++;
        }
            var hunkLines = lines.subList(i + 1, nextHeader);
            if (!hunkLines.isEmpty()) {
                hunks.addAll(parseSingleFileDiff(sourceRange, targetRange, hunkLines));
            }