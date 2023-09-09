/*
You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var isNumberInRow = function(target, row)
{
    let length=row.length;
    for (let index = 0; index < length; index++) 
    {
        if (row[index]==target)
        {
            return true;
        }
    }
    return false;
}

var searchMatrix = function(matrix, target)
{
    let numOfRows=matrix.length, numOfCollums=matrix[0].length;
    let rowIndex=0;

    while (target>matrix[rowIndex][numOfCollums-1])
    {
        rowIndex++;
        if (rowIndex>=numOfRows)
        {
            return false;
        }
    }
    return isNumberInRow(target, matrix[rowIndex]);

};

numbers=[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
num=3;
console.log(searchMatrix(numbers,num));

