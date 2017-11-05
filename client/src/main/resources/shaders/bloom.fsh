varying vec2 texcoord;

vec3 renderDOF(vec3 clr, vec2 coord, vec3 fragpos) {

	float maxBlurFactor							= 0.6;		// To prevent weird results to very close objects.
	float blurStartDistance					= 100.0;
	float chromaticAberrationOffset	= 0.5;
	float gaux2Mipmapping						= 5.0;

	vec3 blurSample = clr;

	#if defined depthOfField || defined distanceBlur

		vec2 aspectcorrect	= vec2(1.0, aspectRatio);

		float getDepth	= texture2D(depthtex2, coord.st).x;
		float focus			= getDepth - centerDepthSmooth;
		float factor		= 0.0;

		#ifdef depthOfField
			factor = focus * blurFactor * 7.5;
		#endif

		#ifdef distanceBlur

			factor += (1.0 - exp(-pow(length(fragpos) / blurStartDistance, 3.0))) * blurFactor * 0.09;

		#endif

		factor = clamp(factor, -maxBlurFactor, maxBlurFactor);

		#ifdef underwaterBlur
			if (float(isEyeInWater) > 0.9) factor = 0.75;
		#endif

		#ifdef chromaticAberration

			vec2 chromAberation = vec2((factor * chromaticAberrationOffset) / 100.0, 0.0);

			for(int i = 0; i < 28; i++) {

				blurSample.r += texture2DLod(composite, coord.st + circlePattern[i] * aspectcorrect * (factor / 100.0) + chromAberation,	gaux2Mipmapping * abs(factor)).r * maxColorRange;
				blurSample.g += texture2DLod(composite, coord.st + circlePattern[i] * aspectcorrect * (factor / 100.0),									gaux2Mipmapping * abs(factor)).g * maxColorRange;
				blurSample.b += texture2DLod(composite, coord.st + circlePattern[i] * aspectcorrect * (factor / 100.0) - chromAberation,	gaux2Mipmapping * abs(factor)).b * maxColorRange;

			}

		#else

			for(int i = 0; i < 28; i++) {

				blurSample += texture2DLod(composite, coord.st + circlePattern[i] * aspectcorrect * (factor / 100.0), gaux2Mipmapping * abs(factor)).rgb * maxColorRange;

			}

		#endif

		blurSample /= 28.0;

	#endif


	return blurSample;

}

vec3 calcBloom(vec3 clr, vec2 coord) {

	float bloomStength = 1.0;
	float bloomPow = 0.25;

	#ifdef bloom

	vec3 blur  = pow(texture2D(gaux4, coord / pow(2.0, 2.0) + vec2(0.0, 0.0)).rgb, vec3(2.2)) * pow(7.0, bloomPow);
			 blur += pow(texture2D(gaux4, coord / pow(2.0, 3.0) + vec2(0.3, 0.0)).rgb, vec3(2.2)) * pow(6.0, bloomPow);
			 blur += pow(texture2D(gaux4, coord / pow(2.0, 4.0) + vec2(0.0, 0.3)).rgb, vec3(2.2)) * pow(5.0, bloomPow);
			 blur += pow(texture2D(gaux4, coord / pow(2.0, 5.0) + vec2(0.1, 0.3)).rgb, vec3(2.2)) * pow(4.0, bloomPow);
			 blur += pow(texture2D(gaux4, coord / pow(2.0, 6.0) + vec2(0.2, 0.3)).rgb, vec3(2.2)) * pow(3.0, bloomPow);
			 blur += pow(texture2D(gaux4, coord / pow(2.0, 7.0) + vec2(0.3, 0.3)).rgb, vec3(2.2)) * pow(2.0, bloomPow);

			 blur *= maxColorRange;

	float bmval = 0.03 * 7.0 / pow(7.0, bloomPow);

	clr.rgb = mix(clr.rgb, blur, bmval * bloomStength);

	#endif

	return clr;

}

void main(void) {
	vec4 color = gl_FragColor;
	color.rgb = gl_Position.xy + vec2(0, 1);
	//color.rgb = calcBloom(color.rgb, texcoord.xy);
	gl_FragColor = color;
}