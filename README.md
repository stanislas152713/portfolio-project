# Portfolio Project

## Summary
This is a portfolio project done in my Software II course under the guidance of Jeremy Grifski. The component I created is called a story generator.

It produces a sequence (e.g., A-B-C) where each part is a random selection from its respective category set. Story generator is designed for creators to collect ideas and generate random combinations of ideas that may inspire them.

In this project, I
- Architected a 4-tier software hierarchy (Kernel, Enhanced, Abstract, Implementation) following the OSU Software Sequence discipline to model a complex plot generation system.
- Engineered a robust kernel to achieve O(1) average-time lookup for element categories and story templates while maintaining strict Representation Invariants and Correspondence.
- Authored formal behavioral specifications using Design by Contract (DbC) annotations and designed a JUnit test suite that validates non-deterministic methods through statistical verification.


In the `src` folder, you can find all code in the `components` folder, as well as a demo and a simple application of quiz bank to show how this component can be used as an implementation of other data types.