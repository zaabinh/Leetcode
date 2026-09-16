# Scaffolds a LeetCode solution folder, source file and run script.
#
# Usage:
#   .\create_solution_folder.ps1 <Problem_Name>            # creates both Python and Java
#   .\create_solution_folder.ps1 <Problem_Name> Java       # Java only
#   .\create_solution_folder.ps1 <Problem_Name> Python     # Python only

$PROB_NAME = $args[0]
$LANG      = $args[1]

if ([string]::IsNullOrWhiteSpace($PROB_NAME)) {
    Write-Warning "Error: Missing required parameter!"
    Write-Host "Usage: .\create_solution_folder.ps1 <Problem_Name> [Java|Python]" -ForegroundColor Cyan
    exit 1
}

$ROOT = "D:/ZB/Code/Personal/Leetcode"

# Decide which languages to generate
$targets = @("Python", "Java")
if (-not [string]::IsNullOrWhiteSpace($LANG)) {
    switch ($LANG.ToLower()) {
        "java"   { $targets = @("Java") }
        "python" { $targets = @("Python") }
        "py"     { $targets = @("Python") }
        default  {
            Write-Warning "Unknown language '$LANG'. Supported: Java, Python."
            exit 1
        }
    }
}

# Per-language templates: source file name, source body, run script body
$templates = @{
    "Java" = @{
        SourceFile = "Main.java"
        Source = @'
class Solution {

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
'@
        RunScript = @'
javac Main.java
java Main
'@
    }
    "Python" = @{
        SourceFile = "solution.py"
        Source = @'
class Solution:
    def solve(self):
        pass


if __name__ == "__main__":
    s = Solution()
'@
        RunScript = @'
python solution.py
'@
    }
}

foreach ($lang in $targets) {
    $tpl        = $templates[$lang]
    $targetDir  = Join-Path $ROOT (Join-Path $lang $PROB_NAME)
    $sourcePath = Join-Path $targetDir $tpl.SourceFile
    $runPath    = Join-Path $targetDir "run_script.ps1"

    $null = New-Item -ItemType Directory -Force -Path $targetDir

    # Write source without a BOM; don't clobber an existing solution
    if (Test-Path $sourcePath) {
        Write-Host "[$lang] $($tpl.SourceFile) already exists, keeping it." -ForegroundColor Yellow
    } else {
        [System.IO.File]::WriteAllText($sourcePath, $tpl.Source)
    }

    [System.IO.File]::WriteAllText($runPath, $tpl.RunScript)

    Set-Location $targetDir
    Write-Host "[$lang] ready at $targetDir" -ForegroundColor Green
}
