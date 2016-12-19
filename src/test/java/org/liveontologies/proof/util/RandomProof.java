package org.liveontologies.proof.util;

/*-
 * #%L
 * OWL API Proof Extension
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2016 Live Ontologies Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomProof {

	public static ProofNode<Integer> generate(Random random, int maxConclusions,
			int maxPremises, int maxInferences) {
		List<Integer> derived = new ArrayList<Integer>(maxConclusions);
		Set<Integer> derivedSet = new HashSet<Integer>(maxConclusions);
		MockProof<Integer> proof = MockProof.create();
		for (int i = 0; i < maxInferences; i++) {
			int conclusion = random.nextInt(maxConclusions);
			MockProof<Integer>.MockProofStepBuilder b = proof
					.conclusion(conclusion);
			int noPremises = random.nextInt(maxPremises);
			if (derived.size() < noPremises) {
				noPremises = derived.size();
			}
			for (int j = 0; j < noPremises; j++) {
				int premise = derived.get(random.nextInt(derived.size()));
				b.premise(premise);
			}
			b.build();
			if (derivedSet.add(conclusion)) {
				derived.add(conclusion);
			}
		}
		// return the last derived
		return proof.getNode(derived.get(derived.size() - 1));
	}

	public static ProofNode<Integer> generate(Random random, int maxConclusions,
			int maxPremises) {
		return generate(random, maxConclusions, maxPremises,
				maxConclusions + random.nextInt(2 * maxConclusions));
	}

	public static ProofNode<Integer> generate(Random random,
			int maxConclusions) {
		return generate(random, maxConclusions, 3 + random.nextInt(5));
	}

	public static ProofNode<Integer> generate(Random random) {
		return generate(random, random.nextInt(100));
	}

	public static ProofNode<Integer> generate() {
		return generate(new Random());
	}

}
