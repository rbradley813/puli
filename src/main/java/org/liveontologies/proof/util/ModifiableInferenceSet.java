/*-
 * #%L
 * Proof Utility Library
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2017 Live Ontologies Project
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
package org.liveontologies.proof.util;

public interface ModifiableInferenceSet<C, I extends Inference<C>>
		extends GenericInferenceSet<C, I>, Producer<I> {

	/**
	 * Add the given inference to this {@link InferenceSet}
	 * 
	 * @param inference
	 */
	@Override
	void produce(I inference);

	/**
	 * Remove all inferences from this {@link InferenceSet}
	 */
	void clear();

	public static interface Projection<C>
			extends ModifiableInferenceSet<C, Inference<C>> {
		// Empty.
	}

}
