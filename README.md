# GeckoLib Examples
## What is this?
This is a repository containing officially managed example mods set up using various [GeckoLib](https://github.com/bernie-g/geckolib) features.

The aim is to have an example mod deployment for each major loader on each appropriately major version of Minecraft.
If a branch is not present for the Minecraft version of your choice, then the next highest version branch will be the most relevant to you.

Each example is held in its own self-contained branch. Each deployment follows the following ideology:
1. Obtain the most recent MDK for the given platform
2. Ensure all toolchain values (gradle, parchment, etc) are up to date
3. Trim the template down to the bare minimum required to run
4. Implement GeckoLib example objects

This allows for each deployment to be a working mod built just like anyone else might start their mod

You can browse the available example mods via the branches menu [here](https://github.com/bernie-g/geckolib-examples/branches/all)

## What if I want to check these out in dev?
You can either clone the branch of this repo you are interested in and go from there, or you can do a dependency in your dev space
on the example mod, which is hosted in the same maven repository as GeckoLib itself.

E.G. `implementation("software.bernie.geckolib:geckolib-examples-ml-neoforge-${minecraft_version}:1.0.0`

NOTE: If you publish your mod to a maven, you will want to disable the dependency prior to publishing, otherwise the example mod may end up being published as a dependency of your mod

## Questions?
Jump in our [Discord](https://discord.gg/pPEqBgJtZW)!