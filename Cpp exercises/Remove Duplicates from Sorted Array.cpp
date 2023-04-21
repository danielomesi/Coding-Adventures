//This is a leet code made by Daniel Omesi
//"Remove Duplicates from Sorted Array" - receives a vector of sorted numbers,
//the function removes the duplicated numbers and retrurns the number of unique numbers in it as integer k,
//and modifies the vector to  so that the first k elements are the unique ones

using namespace std;
#include <iostream>
#include <vector> 


int removeDuplicates(vector<int>& nums);
void removeIndex(int indexToRemove, vector<int>& arr);

void main()
{
	vector<int> arr{ 0,0,0,1,4,4,4,5,6,8,8,9,10,10,11};

	int k = removeDuplicates(arr);
	cout << "The num of unique nums is " << k <<" and they are: " << endl;
	for (int i=0;i<k;i++)
	{
		cout << arr[i] << endl;
	}
}


int removeDuplicates(vector<int>& nums)
{
	int counter = 0, uniqueNum, i = 0, j, curr, next;
	int size = nums.size()-1;
	if (nums.size() > 0)
	{
		counter++;
		uniqueNum = nums[0];
	}
	while (i <= size)
	{
		curr = nums[i];
		if ((i + 1) <= size)
		{
			next = nums[i + 1];
			if (curr == next)
			{
				j = i + 1;
				while (j < size)
				{
					if (nums[j] == nums[i])
					{
						removeIndex(j, nums);
						size--;
					}
					else
					{
						counter++;
						uniqueNum = nums[i + 1];
						break;
					}
				}
			}
			else
			{
				uniqueNum = next;
				counter++;
			}
		}
		else if (curr!=uniqueNum)
			counter++;
		i++;
	}
	return counter;
}

void removeIndex(int indexToRemove, vector<int>& arr)
{
	arr.erase(arr.begin() + indexToRemove);
}