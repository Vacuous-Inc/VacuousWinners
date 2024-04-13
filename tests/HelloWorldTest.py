import os
import unittest

import ast
from pathlib import Path
import sys
import unittest
import json

from proc import run, run_flake8

TIMEOUT = 15  # seconds
ENCODING = 'UTF8'
TARGET_FILE = 'Test_Code/HelloWorld.py'

TEST = ["hello world"]

score = 0

def setScore(s):
        score += 1;

if os.environ.get('GS_LOCAL') == 'true':
    print("Running locally...")
    results_path = 'results.json'
else:
    results_path = 'results.json'


class TestHelloWorld(unittest.TestCase):
   
    player = ""
    target = TARGET_FILE
    target_present = False
    world_procs = []

    @classmethod
    def setUpClass(cls):
        
        """This is run once to initialize class. """
        cls.target_file_present = Path(cls.target).is_file()
        if cls.target_file_present:
            for test in TEST:
                cls.world_procs.append(run(cls.target))

    def setUp(self):
        """This is run before each test. """
        self.score = 0
        #if not self.target_file_present:
            #self.fail(f'Target file {self.target_file} not found! '
             #         f'File should be named {self.target_file}.')


    def test_docstring_present(self):
        """Verify docstring is present (element_lookup.py). """
        with open(self.target, 'r') as fh:
            tree = ast.parse(fh.read())
        docstring = ast.get_docstring(tree)
        self.player = docstring
        print(docstring)
        self.assertIsNotNone(docstring)

    def test_print(self):
        for pr in self.world_procs:
            output = pr.stdout
            output.lower()

            expected = TEST[0]
            actual = output

            if actual.find(expected) != -1:
                setScore(1,self.player)
            else:
                print("Expected to find '"+expected+"' in response ")
                     # f"(case-insensitive). \n"
                     # f"Actual: {actual}")
                

    def test_return_code(self):
        """Verify program runs without error (element_lookup.py). """
        ok_count = 0
        score = 0
        all_procs = self.world_procs
        for proc in all_procs:
            if proc.returncode == 0:
                score += 1
                ok_count += 1
            else:
                print("Test failed with non-zero exit code.")
                # TODO Maybe a little explanation is in order (e.g., failed on 999)
        if ok_count == len(all_procs):
            print('Program runs without raising errors. Return codes all 0.')
        else:
            print('Only '+ ok_count+ ' tests ran successfully.')

        setScore(score,self.player)


def run():
    unittest.main()
    return score;