# Usage: .\run_script.ps1 [FileName]   (defaults to Main, e.g. BestSolution)
param(
    [string]$Name = "Main"
)

javac "$Name.java"
java $Name