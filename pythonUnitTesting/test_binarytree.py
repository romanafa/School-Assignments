import unittest

from collections import namedtuple
from BinaryTree import BinaryTree

class MyTestCase(unittest.TestCase):
    # def __init__(self, ):
    #
    # Person = namedtuple("Person", ["last_name", "first_name", "address", "postal_code", "postal_address"])
    #
    # with open("Personer.dta", "r") as file:
    #     person = []
    #     for line in file:
    #         tmp = line.strip().split(";")
    #         person.append(Person(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]))  # namedtuple


    def test_something(self):
        binarytree = BinaryTree()
        binarytree.insert(0,0, person[0])
        self.assertEqual(True, False)  # add assertion here


if __name__ == '__main__':
    unittest.main()
